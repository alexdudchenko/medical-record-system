import {deleteDoctorById, getDoctorById, updateDoctor} from "../../service/DoctorService.js";
import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {Box, Button, ButtonGroup, Text} from "@chakra-ui/react";

export default function DoctorApplication() {

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [email, setEmail] = useState("")
    const [verified, setVerified] = useState("")
    const [birthDate, setBirthDate] = useState("")

    const {id} = useParams()
    const navigator = useNavigate();

    useEffect(() => {
        getDoctorInfo(id)
    }, [id]);

    function getDoctorInfo(id) {
        getDoctorById(id)
            .then(res => {
                setFirstName(res.data.firstName)
                setLastName(res.data.lastName)
                setBirthDate(res.data.birthDate)
                setEmail(res.data.email)
                setVerified(res.data.verified)
            })
            .catch(err => console.error(err))
    }

    function approveCandidate() {
        const doctor = {id, firstName, lastName, birthDate, verified, email}
        doctor.verified = true

        console.log(doctor)

        updateDoctor(id, doctor)
            .then(() => navigator("/verify"))
            .catch(err => console.error(err))
    }

    function rejectApplication() {
        deleteDoctorById(id)
            .then(() => navigator("/verify"))
            .catch(err => console.error(err))
    }

    return (
        <>
            <Box>
                <Text>
                    Name: {firstName}
                </Text>
                <Text>
                    Surname: {lastName}
                </Text>
                <Text>
                    Born: {birthDate}
                </Text>
                <Text>
                    Work email: {email}
                </Text>
                <ButtonGroup>
                    <Button onClick={approveCandidate}>Approve</Button>
                    <Button onClick={rejectApplication}>Reject</Button>
                </ButtonGroup>
            </Box>
        </>
    )
}