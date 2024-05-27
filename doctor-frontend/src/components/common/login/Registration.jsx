import {
    Box,
    Button,
    ButtonGroup, Checkbox, CheckboxGroup,
    FormControl,
    FormLabel,
    Input, MenuItemOption, Select, Spinner, Text, VStack
} from "@chakra-ui/react";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "../../../api/axios.js";
import {useQuery} from "react-query";

export default function Registration() {

    const [selectedSpecializations, setSelectedSpecializations] = useState([]);

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [birthDate, setBirthDate] = useState("")

    const [office, setOffice] = useState("")
    const [position, setPosition] = useState("")
    const [hospitalId, setHospitalId] = useState("")

    const navigate = useNavigate()

    const retrieveSpecialisations = async () => {
        const response = await axios.get("/specialisations")
        return response.data
    }

    const retrieveHospitals = async () => {
        const response = await axios.get("/hospitals")
        return response.data
    }

    const {
        data: specialisations,
        isLoading: specLoading,
        error: specError
    } = useQuery("specialisationsData", retrieveSpecialisations)

    const {
        data: hospitals,
        isLoading: hospitalsLoading,
        error: hospitalsError
    } = useQuery("hospitalsData", retrieveHospitals)

    const handleRegistrationFormSubmission = () => {
        const specialisationObjects = selectedSpecializations.map(id => ({id}))

        const registrationData = {
            firstName,
            lastName,
            email,
            password,
            birthDate,
            specialisations: specialisationObjects,
            placesOfWork: [
                {
                    hospital: {id: hospitalId},
                    default: true,
                    officeNumber: office,
                    position: position
                }
            ]
        }

        console.log(registrationData)

        axios.post("/auth/doctors/registration", registrationData)
            .then(
                () => {
                    setEmail('')
                    setPassword('')
                    navigate("/login")
                }
            )
            .catch(
                err => {
                    console.log("Miss")
                    console.error(err)
                }
            )
    }

    const handleSpecializationChange = (selectedValues) => {
        setSelectedSpecializations(selectedValues);
    };

    if (specLoading || hospitalsLoading) return <Spinner/>

    if (specError || hospitalsError) return <Text>Something went wrong</Text>

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

                <Text>Pick your specialisations</Text>
                <CheckboxGroup
                    value={selectedSpecializations}
                    onChange={handleSpecializationChange}
                >
                    <VStack align="start">
                        {specialisations.map((specialization) => (
                            <Checkbox
                                key={specialization.id}
                                value={specialization.id.toString()}
                            >
                                {specialization.name}
                            </Checkbox>
                        ))}
                    </VStack>
                </CheckboxGroup>

                <Text>Enter your primary place of work</Text>
                <Select placeholder="Select hospital" onChange={(e) => {
                    setHospitalId(e.target.value)
                }}>
                {hospitals.map((hospital) => (
                    <option key={"Hospital" + hospital.id} value={hospital.id.toString()}>
                    {hospital.name}
                </option>
                ))}
            </Select>

            <FormLabel>Office</FormLabel>
            <Input type="text"
                   name="office"
                   onChange={(e) => setOffice(e.target.value)}
            />
            <FormLabel>Position</FormLabel>
            <Input type="text"
                   name="position"
                   onChange={(e) => setPosition(e.target.value)}
            />

            <ButtonGroup>
                <Button type="submit" onClick={handleRegistrationFormSubmission}>Register</Button>
            </ButtonGroup>
        </FormControl>
        </Box>
</>
)
}