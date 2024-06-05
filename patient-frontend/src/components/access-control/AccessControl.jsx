import useAuth from "../../hooks/useAuth.js";
import {useEffect, useState} from "react";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {Box, Button, Heading, Text} from "@chakra-ui/react";

export default function AccessControl() {

    const {auth} = useAuth()
    const axiosPrivate = useAxiosPrivate()
    const [pendingFetched, setPendingFetched] = useState(false)
    const [combinedPendingRequests, setCombinedPendingRequests] = useState([])

    const [permissionsFetched, setPermissionsFetched] = useState(false)
    const [combinedAccessRecords, setCombinedAccessRecords] = useState([])

    useEffect(() => {
        if (!pendingFetched) {
            const fetchData = async () => {
                const pendingReqsRes = await axiosPrivate.get(`/access-requests?status=PENDING&patientId=${auth.profileId}`)
                const pendingReqs = pendingReqsRes.data;

                if (pendingReqs.length > 0) {
                    const ids = pendingReqs
                        .map(req => req.doctorId)
                        .join(",")

                    const doctors = await axiosPrivate.get(`/doctors?ids=${ids}`)

                    doctors.data.forEach(d => {
                        pendingReqs.forEach(r => {
                            if (r.doctorId === d.id) {
                                r.doctor = d
                            }
                        })
                    })
                }
                console.log(pendingReqs)
                setCombinedPendingRequests(pendingReqs)
            }

            fetchData()
            setPendingFetched(true)
        }
    }, [pendingFetched]);

    useEffect(() => {
        if (!permissionsFetched) {
            const fetchData = async () => {
                const accessRecordsRes = await axiosPrivate.get(`/access-records?patientId=${auth.profileId}`)
                const accessRecords = accessRecordsRes.data;
                console.log(accessRecords)
                if (accessRecords.length > 0) {
                    const ids = accessRecords
                        .map(req => req.doctorId)
                        .join(",")

                    const doctors = await axiosPrivate.get(`/doctors?ids=${ids}`)

                    doctors.data.forEach(d => {
                        accessRecords.forEach(r => {
                            if (r.doctorId === d.id) {
                                r.doctor = d
                            }
                        })
                    })
                }

                setCombinedAccessRecords(accessRecords)
            }

            fetchData()
            setPermissionsFetched(true)
        }
    }, [permissionsFetched]);

    const approve = (doctorId, req) => {
        axiosPrivate.post("/access-records", {
            patientId: auth.profileId,
            doctorId: doctorId
        })
            .then(() => {
                axiosPrivate.put(`/access-requests/${req.id}`, {...req, status: "APPROVED"})
            })
            .then(() => {
                setPermissionsFetched(false)
                setPendingFetched(false)
            })
            .catch(err => console.error(err))

    }

    const deny = (doctorId, req) => {
        axiosPrivate.put(`/access-requests/${req.id}`, {...req, status: "DENIED"})
            .then(() => {
                setPermissionsFetched(false)
                setPendingFetched(false)
            })
            .catch(err => console.error(err))
    }

    const revoke = (id) => {
        axiosPrivate.delete(`access-records/${id}`)
            .then(() => setPermissionsFetched(false))
            .catch(err => console.error(err))
    }

    return (
        <>
            <Box>
                <Heading>Pending requests</Heading>
                {
                    combinedPendingRequests.map(req =>(
                            <Box key={"req" + req.id}>
                                <Text>{req.doctor.firstName + " " + req.doctor.lastName}</Text>
                                <Button onClick={() => approve(req.doctor.id, req)}>Approve</Button>
                                <Button onClick={() => deny(req.doctor.id, req)}>Deny</Button>
                            </Box>
                        )
                    )
                }
            </Box>
            <Box>
                <Heading>Approved access</Heading>
                {
                    combinedAccessRecords.map(rec => (
                        <Box key={"rec" + rec.id}>
                            <Text>{rec.doctor.firstName + " " + rec.doctor.lastName}</Text>
                            <Button onClick={() => revoke(rec.id)}>Revoke</Button>
                        </Box>
                    ))
                }
            </Box>
        </>
    )
}