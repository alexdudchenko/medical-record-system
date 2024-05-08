import {deleteDoctorById, getDoctorById, updateDoctor} from "../../service/DoctorService.js";
import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";

export default function DoctorDetails() {

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [birthDate, setBirthDate] = useState("")
    const [email, setEmail] = useState("")
    const [verified, setVerified] = useState("")

    const {id} = useParams()

    const navigator = useNavigate()

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

    function updateDoctorDetails() {
        const doctor = {id, firstName, lastName, birthDate, email, verified}
        updateDoctor(id, doctor)
            .then(() => navigator("/doctors"))
            .catch(err => console.error(err))
    }

    function deleteDoctorDetails() {
        deleteDoctorById(id)
            .then(() => navigator(("/doctors")))
            .catch(err => console.error(err))
    }

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>First name</FormLabel>
                    <Input type="text"
                           value={firstName}
                           name="firstName"
                           onChange={(e) => setFirstName(e.target.value)}
                    />
                    <FormLabel>Last name</FormLabel>
                    <Input type="text"
                           value={lastName}
                           name="secondName"
                           onChange={(e) => setLastName(e.target.value)}
                    />
                    <FormLabel>Birth date</FormLabel>
                    <Input type="text"
                           value={birthDate}
                           name="birthDate"
                           onChange={(e) => setBirthDate(e.target.value)}
                    />
                    <FormLabel>Email</FormLabel>
                    <Input type="text"
                           value={email}
                           name="email"
                           onChange={(e) => setEmail(e.target.value)}
                    />
                    <FormLabel>Verified</FormLabel>
                    <Input type="text" value={verified ? "yes" : "no"} disabled="true"/>
                    <ButtonGroup>
                        <Button type="submit" onClick={updateDoctorDetails}>Update doctor details</Button>
                        <Button onClick={deleteDoctorDetails}>Delete {"doctor's"} profile</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}