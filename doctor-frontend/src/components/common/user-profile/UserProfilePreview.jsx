// eslint-disable-next-line react/prop-types
import {Flex, Heading, Text} from "@chakra-ui/react";

export default function UserProfilePreview({user}) {
    return (
        <>
            <Flex h="100px" w="300px" direction="column" justify="space-around">
                <Heading as="h6" fontSize="22px">{user.firstName + ' ' + user.lastName}</Heading>
                <Text>{user.birthDate}</Text>
            </Flex>
        </>
    )
}