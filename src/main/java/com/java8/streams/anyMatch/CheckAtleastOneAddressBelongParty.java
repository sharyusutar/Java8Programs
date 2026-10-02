package com.java8.streams.anyMatch;

import java.util.*;

public class CheckAtleastOneAddressBelongParty {

    static class Address {
        private final String partyId;

        Address(String partyId) {
            this.partyId = partyId;
        }

        String getPartyId() {
            return partyId;
        }
    }

    public static void main(String[] args) {
        List<Address> existingAddresses = Arrays.asList(
                new Address("P100"),
                null,                 // Skipped: address is null
                new Address(null),    // Skipped: party ID is null
                new Address("P200")
        );

        List<String> partyIdsBeingModifiedOrDeleted =
                Arrays.asList("p200", "P300");
/*
        boolean hasRelevantAddress = existingAddresses.stream()
                .anyMatch(address ->
                        address != null
                                && address.getPartyId() != null
                                && partyIdsBeingModifiedOrDeleted.stream()
                                .anyMatch(partyId ->
                                        partyId.equalsIgnoreCase(address.getPartyId())
                                )
                );
                */


        //with System.out.println

        boolean hasRelevantAddress = existingAddresses.stream()
                .anyMatch(address -> {
                    if (address == null || address.getPartyId() == null) {
                        System.out.println("Skipping null address or null party ID.");
                        return false;
                    }

                    System.out.println("Checking address party ID: " + address.getPartyId());

                    return partyIdsBeingModifiedOrDeleted.stream()
                            .anyMatch(partyId -> {
                                boolean matches = partyId != null
                                        && partyId.equalsIgnoreCase(address.getPartyId());

                                System.out.println(
                                        "Comparing " + partyId
                                                + " with " + address.getPartyId()
                                                + " -> " + matches
                                );

                                return matches;
                            });
                });

        System.out.println("hasRelevantAddress: " + hasRelevantAddress);


        /*
        for (Address address : existingAddresses) {
            if (address == null || address.getPartyId() == null) {
                continue;
            }

            for (String partyId : changedPartyIds) {
                if (partyId != null
                        && partyId.equalsIgnoreCase(address.getPartyId())) {
                    matchFound = true;
                    break; // Stop checking party IDs
                }
            }

            if (matchFound) {
                break; // Stop checking addresses
            }
        }
         */

        if (hasRelevantAddress) {
            System.out.println(
                    "Relevant address found. Proceed with internal address-delete operation."
            );
            // Call the internal address-delete operation here.
        } else {
            System.out.println(
                    "No relevant address found. Skip internal address-delete operation."
            );
        }
    }
}
