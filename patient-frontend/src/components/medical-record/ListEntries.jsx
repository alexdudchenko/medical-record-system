import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {Link, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Flex, Heading, HStack} from "@chakra-ui/react";
import useAuth from "../../hooks/useAuth.js";

export default function ListEntries() {

    const axiosPrivate = useAxiosPrivate()
    const {auth} = useAuth()

    const [medicalEntries, setMedicalEntries] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/entries?patientId=${auth.profileId}`)
            .then(res => {
                setMedicalEntries(res.data)
            })
            .catch(err => console.error(err))
    }, []);

    return (
        <>
            <Heading as="h1">Entries</Heading>
            <HStack margin="auto">
                <Link to={`/medical-record/vaccinations`}>
                    Vaccinations
                </Link>
                <Link to={`/medical-record/prescriptions`}>
                    Prescriptions
                </Link>
                <Link to={`/medical-record/referrals`}>
                    Referrals
                </Link>
            </HStack>
            <Flex justify="flex-start" direction="column">
                {
                    medicalEntries.map((entry) => (
                        <Link key={entry.id} to={`${entry.id}`}>
                            <Heading>{entry.title}</Heading>
                        </Link>
                    ))
                }
            </Flex>
        </>
    )
}