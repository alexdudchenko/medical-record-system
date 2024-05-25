import {useEffect, useState} from "react";
import {useNavigate, useParams, Link} from "react-router-dom";
import {
    Box, Button, Text
} from "@chakra-ui/react";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import useAuth from "../../hooks/useAuth.js";

export default function PatientDetails() {

    const axiosPrivate = useAxiosPrivate()

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [birthDate, setBirthDate] = useState("")
    const [email, setEmail] = useState("")
    const [uid, setUid] = useState("")
    const [requestedAccess, setRequestedAccess] = useState(false)

    const {id} = useParams()
    const {auth} = useAuth()

    const navigator = useNavigate()

    const [doctorPermissions, setDoctorPermissions] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/patients/${id}`)
            .then(res => {
                setFirstName(res.data.firstName)
                setLastName(res.data.lastName)
                setBirthDate(res.data.birthDate)
                setEmail(res.data.email)
                setUid(res.data.uid)
            })
            .catch(err => console.error(err))

        axiosPrivate.get(`/access-records?patientId=${id}&doctorId=${auth.profileId}`)
            .then(res => setDoctorPermissions(res.data))
            .catch(err => console.error(err))

        axiosPrivate.get(`/access-requests?status=PENDING&patientId=${id}&doctorId=${auth.profileId}`)
            .then(res => setRequestedAccess(res?.data?.length !== 0))
            .catch(err => console.error(err))
    }, []);

    const requestAccess = () => {
        axiosPrivate.post(`/access-requests`, {patientId: id, doctorId: auth.profileId, status: "PENDING"})
            .then(() => setRequestedAccess(true))
            .catch(err => console.error(err))
    }

    return (
        <>
            <Box w="50%" margin="auto">
                <Box>
                    First name: {firstName}
                </Box>
                <Box>
                    Last name: {lastName}
                </Box>
                <Box>
                    Uid: {uid}
                </Box>
                <Box>
                    Birth date: {birthDate}
                </Box>
                <Box>
                    Email: {email}
                </Box>
                {
                    doctorPermissions.length === 0
                        ? requestedAccess
                            ? <Text>Wait patient approval</Text>
                            : <Button onClick={requestAccess}> Request access</Button>
                        : <Link to={`/patients/${id}/medical-record`}>Go to medical record</Link>
                }
            </Box>
        </>
    )
}