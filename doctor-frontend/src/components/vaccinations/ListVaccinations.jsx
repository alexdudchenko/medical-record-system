import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {Link, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Box, Flex, Heading, Text} from "@chakra-ui/react";

export default function ListVaccinations() {

    const axiosPrivate = useAxiosPrivate()
    const {id} = useParams()

    const [vaccinations, setVaccinations] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/vaccinations?patientId=${id}`)
            .then(res => {
                setVaccinations(res.data)
            })
            .catch(err => console.error(err))
    }, []);

    return (
        <>
            <Heading as="h1">Vaccinations</Heading>
            <Flex justify="flex-start" direction="column">
                {
                    vaccinations.map((vaccination) => (
                        <Box key={vaccination.id}>
                            <Heading>{vaccination.vaccine}</Heading>
                            <Text>{vaccination.doseNumber}</Text>
                            <Text>{vaccination.manufacturer}</Text>
                            <Text>{vaccination.serialNumber}</Text>
                            <Text>{vaccination.vaccinatedDate}</Text>
                            <Text>{vaccination.expiryDate}</Text>
                            <Text>{vaccination.dosage}</Text>
                            <Text>{vaccination.injectionSite}</Text>
                        </Box>
                    ))
                }
            </Flex>
        </>
    )
}