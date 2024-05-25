import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {Link} from "react-router-dom"
import {useEffect, useState} from "react";
import {Flex, Heading} from "@chakra-ui/react";
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