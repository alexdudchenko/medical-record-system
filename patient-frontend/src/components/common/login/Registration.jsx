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
    const [gender, setGender] = useState("")
    const [personalPhoneNumber, setPersonalPhoneNumber] = useState("")
    const [workPhoneNumber, setWorkPhoneNumber] = useState("")
    const [company, setCompany] = useState("")
    const [country, setCountry] = useState("")
    const [city, setCity] = useState("")
    const [streetLine1, setStreetLine1] = useState("")
    const [streetLine2, setStreetLine2] = useState("")
    const [index, setIndex] = useState("")

    const navigate = useNavigate()

    const handleRegistrationFormSubmission = () => {
        axios.post("/auth/patients/registration", {
            firstName,
            lastName,
            email,
            password,
            birthDate,
            gender,
            personalPhoneNumber,
            workPhoneNumber,
            company,
            address: {
                country,
                city,
                streetLine1,
                streetLine2,
                index
            }
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
            <Box w="25%" margin="auto" marginTop="10px">
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
                    <FormLabel>Gender</FormLabel>
                    <Input type="text"
                           name="gender"
                           onChange={(e) => setGender(e.target.value)}
                    />
                    <FormLabel>Personal Phone Number</FormLabel>
                    <Input type="text"
                           name="personalPhoneNumber"
                           onChange={(e) => setPersonalPhoneNumber(e.target.value)}
                    />
                    <FormLabel>Work Phone Number</FormLabel>
                    <Input type="text"
                           name="workPhoneNumber"
                           onChange={(e) => setWorkPhoneNumber(e.target.value)}
                    />
                    <FormLabel>Company</FormLabel>
                    <Input type="text"
                           name="company"
                           onChange={(e) => setCompany(e.target.value)}
                    />
                    <FormLabel>Country</FormLabel>
                    <Input type="text"
                           name="country"
                           onChange={(e) => setCountry(e.target.value)}
                    />
                    <FormLabel>City</FormLabel>
                    <Input type="text"
                           name="city"
                           onChange={(e) => setCity(e.target.value)}
                    />
                    <FormLabel>Address line 1</FormLabel>
                    <Input type="text"
                           name="streetLine1"
                           onChange={(e) => setStreetLine1(e.target.value)}
                    />
                    <FormLabel>Address line 2</FormLabel>
                    <Input type="text"
                           name="streetLine2"
                           onChange={(e) => setStreetLine2(e.target.value)}
                    />
                    <FormLabel>Index</FormLabel>
                    <Input type="text"
                           name="index"
                           onChange={(e) => setIndex(e.target.value)}
                    />
                    <ButtonGroup marginTop="10px">
                        <Button type="submit" onClick={handleRegistrationFormSubmission}>Register</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}