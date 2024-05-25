import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {VStack, Text, Stack} from "@chakra-ui/react";

export default function MedicalEntryDetails() {

    const axiosPrivate = useAxiosPrivate()
    const [entry, setEntry] = useState("")
    const {entryId} = useParams()

    useEffect(() => {
        axiosPrivate.get(`/entries/${entryId}`)
            .then(res => setEntry(res.data))
            .catch(err => console.log(err))
    }, []);

    return (
        <>
            <Stack>
                <Text as="b" align="left">
                    {entry.title}
                </Text>
                <Text align="left">
                    {entry.description}
                </Text>
            </Stack>
        </>
    )
}