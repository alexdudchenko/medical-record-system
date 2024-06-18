import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {Link, useParams} from "react-router-dom"
import {useEffect, useState} from "react";
import {Flex, Heading, HStack} from "@chakra-ui/react";

export default function ListEntries() {

    const axiosPrivate = useAxiosPrivate()
    const {id} = useParams()

    const [medicalEntries, setMedicalEntries] = useState([])

    useEffect(() => {
        axiosPrivate.get(`/entries?patientId=${id}`)
            .then(res => {
                setMedicalEntries(res.data)
            })
            .catch(err => console.error(err))
    }, []);

    return (
        <>
            <Heading as="h1">Entries</Heading>
            <HStack margin="auto">
                <Link to={"create"}>
                    Create new entry
                </Link>
                <Link to={`/patients/${id}/medical-record/vaccinations/create`}>
                    Create Vaccination
                </Link>
                <Link to={`/patients/${id}/medical-record/prescriptions/create`}>
                    Create Prescription
                </Link>

                <Link to={`/patients/${id}/medical-record/referrals/create`}>
                    Create Referral
                </Link>
            </HStack>
            <HStack margin="auto">
                <Link to={`/patients/${id}/medical-record/vaccinations`}>
                    Vaccinations
                </Link>
                <Link to={`/patients/${id}/medical-record/prescriptions`}>
                    Prescriptions
                </Link>
                <Link to={`/patients/${id}/medical-record/referrals`}>
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