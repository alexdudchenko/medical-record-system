import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Flex, Heading, Text} from "@chakra-ui/react";

export default function ListPrescriptions() {

    const axiosPrivate = useAxiosPrivate()
    const {id} = useParams()

    const [prescriptions, setPrescriptions] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/prescriptions?patientId=${id}`)
            .then(res => {
                setPrescriptions(res.data)
            })
            .catch(err => console.error(err))
    }, []);

    return (
        <>
            <Heading as="h1">Vaccinations</Heading>
            <Flex justify="flex-start" direction="column">
                {
                    prescriptions.map((prescription) => (
                        <Box key={prescription.uid}>
                            <Heading>{prescription.medicine}</Heading>
                            <Text>{prescription.packages}</Text>
                            <Text>{prescription.dosage}</Text>
                            <Text>{prescription.duration}</Text>
                            <Text>{prescription.frequency}</Text>
                            <Text>{prescription.creationDate}</Text>
                            <Text>{prescription.expiryDate}</Text>
                            <Text>{prescription.specialInstructions}</Text>
                        </Box>
                    ))
                }
            </Flex>
        </>
    )
}