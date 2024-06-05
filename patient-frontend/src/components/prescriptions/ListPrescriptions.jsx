import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useEffect, useState} from "react";
import {Box, Flex, Heading, Text} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function ListPrescriptions() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [prescriptions, setPrescriptions] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/prescriptions?patientId=${auth.profileId}`)
            .then(res => {
                setPrescriptions(res.data)
            })
            .catch(err => console.error(err))
    }, []);

    return (
        <>
            <Heading as="h1">Prescriptions</Heading>
            <Flex justify="flex-start" direction="column">
                {
                    prescriptions.length !== 0
                        ? prescriptions.map((prescription) => (
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
                        : <Text>Nothing to show</Text>
                }
            </Flex>
        </>
    )
}