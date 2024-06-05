import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useNavigate, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function CreateReferral() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [specialist, setSpecialist] = useState("")
    const [expiryDate, setExpiryDate] = useState("")
    const [medicalRecord, setMedicalRecord] = useState({})

    const {id} = useParams()
    const navigate = useNavigate()

    useEffect(() => {
        axiosPrivate.get(`/records?patientId=${id}`)
            .then(res => setMedicalRecord(res.data[0]))
            .catch(err => console.error(err))
    }, []);

    const handleSubmit = () => {
        console.log(medicalRecord)
        axiosPrivate.post("/referrals",
            {
                specialist,
                expiryDate,
                doctorId: auth.profileId,
                medicalRecord
            })
            .then(() => navigate(`/patients/${id}/medical-record/`))
            .catch(err => console.error(err))
    }

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>Specialist</FormLabel>
                    <Input type="text"
                           name="specialist"
                           onChange={(e) => setSpecialist(e.target.value)}
                    />
                    <FormLabel>Expiry Date</FormLabel>
                    <Input type="text"
                           name="expiryDate"
                           onChange={(e) => setExpiryDate(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={handleSubmit}>Create new referral</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}