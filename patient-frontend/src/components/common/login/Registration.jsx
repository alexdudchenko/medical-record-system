import {
    Box,
    Button,
    ButtonGroup,
    FormControl,
    FormLabel,
    Input
} from "@chakra-ui/react";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "../../../api/axios.js";

export default function Registration() {
    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [birthDate, setBirthDate] = useState("")

    const navigate = useNavigate()

    const handleRegistrationFormSubmission = () => {
        axios.post("/auth/patients/registration", {
            firstName,
            lastName,
            email,
            password,
            birthDate
        })
            .then(
                () => {
                    setEmail('')
                    setPassword('')
                    navigate("/login")
                }
            )
            .catch(
                err => {
                    console.error(err)
                }
            )
    }

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>First name</FormLabel>
                    <Input type="text"
                           name="firstName"
                           onChange={(e) => setFirstName(e.target.value)}
                    />
                    <FormLabel>Last name</FormLabel>
                    <Input type="text"
                           name="lastName"
                           onChange={(e) => setLastName(e.target.value)}
                    />
                    <FormLabel>Email</FormLabel>
                    <Input type="text"
                           name="email"
                           onChange={(e) => setEmail(e.target.value)}
                    />
                    <FormLabel>Password</FormLabel>
                    <Input type="password"
                           name="password"
                           onChange={(e) => setPassword(e.target.value)}
                    />
                    <FormLabel>Birth date in format yyyy-MM-dd</FormLabel>
                    <Input type="text"
                           name="birthDate"
                           onChange={(e) => setBirthDate(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={handleRegistrationFormSubmission}>Register</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}