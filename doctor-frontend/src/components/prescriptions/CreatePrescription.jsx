import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useNavigate, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function CreatePrescription() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [medicine, setMedicine] = useState("")
    const [packages, setPackages] = useState("")
    const [duration, setDuration] = useState("")
    const [frequency, setFrequency] = useState("")
    const [specialInstructions, setSpecialInstructions] = useState("")
    const [dosage, setDosage] = useState("")
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
        axiosPrivate.post("/prescriptions",
            {
                medicine,
                packages,
                duration,
                frequency,
                specialInstructions,
                dosage,
                expiryDate,
                authorId: auth.profileId,
                medicalRecord
            })
            .then(() => navigate(`/patients/${id}/medical-record/`))
            .catch(err => console.error(err))
    }


    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>Medicine</FormLabel>
                    <Input type="text"
                           name="medicine"
                           onChange={(e) => setMedicine(e.target.value)}
                    />
                    <FormLabel>Packages</FormLabel>
                    <Input type="text"
                           name="packages"
                           onChange={(e) => setPackages(e.target.value)}
                    />
                    <FormLabel>Duration</FormLabel>
                    <Input type="text"
                           name="duration"
                           onChange={(e) => setDuration(e.target.value)}
                    />
                    <FormLabel>Frequency</FormLabel>
                    <Input type="text"
                           name="frequency"
                           onChange={(e) => setFrequency(e.target.value)}
                    />
                    <FormLabel>Special Instructions</FormLabel>
                    <Input type="text"
                           name="specialInstructions"
                           onChange={(e) => setSpecialInstructions(e.target.value)}
                    />
                    <FormLabel>Expiry Date</FormLabel>
                    <Input type="text"
                           name="expiryDate"
                           onChange={(e) => setExpiryDate(e.target.value)}
                    />
                    <FormLabel>Dosage</FormLabel>
                    <Input type="text"
                           name="dosage"
                           onChange={(e) => setDosage(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={handleSubmit}>Create new prescription</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}