// eslint-disable-next-line react/prop-types
import {Flex, Heading} from "@chakra-ui/react";

export default function MedicalRecordEntryPreview({record}) {
    return (
        <>
            <Flex h="100px" direction="column" justify="space-around">
                <Heading as="h6" fontSize="22px">{record.title}</Heading>
            </Flex>
        </>
    )
}