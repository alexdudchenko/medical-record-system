import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";
import {deletePatientById, getPatientById, updatePatient} from "../../service/PatientService.js";

export default function PatientDetails() {

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [birthDate, setBirthDate] = useState("")
    const [email, setEmail] = useState("")
    const [uid, setUid] = useState("")

    const {id} = useParams()

    const navigator = useNavigate()

    useEffect(() => {
        getPatientInfo(id)
    }, [id]);

    function getPatientInfo(id) {
        getPatientById(id)
            .then(res => {
                setFirstName(res.data.firstName)
                setLastName(res.data.lastName)
                setBirthDate(res.data.birthDate)
                setEmail(res.data.email)
                setUid(res.data.uid)
            })
            .catch(err => console.error(err))
    }

    function updatePatientDetails() {
        const patient = {id, firstName, lastName, birthDate, email, uid}
        console.log(patient)
        updatePatient(id, patient)
            .then(() => navigator("/patients"))
            .catch(err => console.error(err))
    }

    function deletePatientDetails() {
        deletePatientById(id)
            .then(() => navigator(("/patients")))
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
                    <FormLabel>Email</FormLabel>
                    <Input type="text"
                           value={uid}
                           name="uid"
                           onChange={(e) => setUid(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={updatePatientDetails}>Update patient details</Button>
                        <Button onClick={deletePatientDetails}>Delete {"patient's"} profile</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}