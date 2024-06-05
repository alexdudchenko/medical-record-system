import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useNavigate, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function CreateVaccination() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [vaccine, setVaccine] = useState("")
    const [doseNumber, setDoseNumber] = useState("")
    const [manufacturer, setManufacturer] = useState("")
    const [serialNumber, setSerialNumber] = useState("")
    const [vaccinatedDate, setVaccinatedDate] = useState("")
    const [expiryDate, setExpiryDate] = useState("")
    const [dosage, setDosage] = useState("")
    const [injectionSite, setInjectionSite] = useState("")
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
        axiosPrivate.post("/vaccinations",
            {
                vaccine,
                doseNumber,
                manufacturer,
                serialNumber,
                vaccinatedDate,
                expiryDate,
                dosage,
                injectionSite,
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
                    <FormLabel>Vaccine</FormLabel>
                    <Input type="text"
                           name="vaccine"
                           onChange={(e) => setVaccine(e.target.value)}
                    />
                    <FormLabel>Dose number</FormLabel>
                    <Input type="text"
                           name="doseNumber"
                           onChange={(e) => setDoseNumber(e.target.value)}
                    />
                    <FormLabel>Manufacturer</FormLabel>
                    <Input type="text"
                           name="manufacturer"
                           onChange={(e) => setManufacturer(e.target.value)}
                    />
                    <FormLabel>Serial Number</FormLabel>
                    <Input type="text"
                           name="serialNumber"
                           onChange={(e) => setSerialNumber(e.target.value)}
                    />
                    <FormLabel>Vaccinated Date</FormLabel>
                    <Input type="text"
                           name="vaccinatedDate"
                           onChange={(e) => setVaccinatedDate(e.target.value)}
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
                    <FormLabel>Injection Site</FormLabel>
                    <Input type="text"
                           name="injectionSite"
                           onChange={(e) => setInjectionSite(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={handleSubmit}>Create new vaccination</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}