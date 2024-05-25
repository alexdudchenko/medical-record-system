import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {Link, useNavigate, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Button, ButtonGroup, Flex, FormControl, FormLabel, Heading, Input} from "@chakra-ui/react";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";

export default function CreateEntry() {

    const axiosPrivate = useAxiosPrivate()
    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
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
        axiosPrivate.post("/entries", {title, description, medicalRecord})
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
                    <ButtonGroup>
                        <Button type="submit" onClick={handleSubmit}>Create new entry</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}