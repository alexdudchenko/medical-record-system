import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useEffect, useState} from "react";
import {Box, Flex, Heading, Text} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function ListReferrals() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [referrals, setReferrals] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/referrals?patientId=${auth.profileId}`)
            .then(res => {
                setReferrals(res.data)
            })
            .catch(err => console.error(err))
    }, []);

    return (
        <>
            <Heading as="h1">Referrals</Heading>
            <Flex justify="flex-start" direction="column">
                {
                    referrals.length !== 0 ?
                        referrals.map((prescription) => (
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