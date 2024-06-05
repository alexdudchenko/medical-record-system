import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useNavigate, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function CreateEntry() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
    const [diagnosis, setDiagnosis] = useState("")
    const [treatmentPlan, setTreatmentPlan] = useState("")
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
        axiosPrivate.post("/entries", {title,
            description,
            diagnosis,
            treatmentPlan,
            authorId: auth.profileId,
            medicalRecord})
            .then(res => navigate(`/patients/${id}/medical-record/${res.data.id}`))
            .catch(err => console.error(err))
    }


    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>Title</FormLabel>
                    <Input type="text"
                           name="title"
                           onChange={(e) => setTitle(e.target.value)}
                    />
                    <FormLabel>Description</FormLabel>
                    <Input type="text"
                           name="description"
                           onChange={(e) => setDescription(e.target.value)}
                    />
                    <FormLabel>Diagnosis</FormLabel>
                    <Input type="text"
                           name="diagnosis"
                           onChange={(e) => setDiagnosis(e.target.value)}
                    />
                    <FormLabel>Treatment Plan</FormLabel>
                    <Input type="text"
                           name="treatmentPlan"
                           onChange={(e) => setTreatmentPlan(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={handleSubmit}>Create new entry</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}