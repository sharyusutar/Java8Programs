package com.java8.streams.Optional;
import java.util.Optional;
public class UsingOptionalHandleMissingRateRevisionData {
    static String getRefreshFrequency(
            FinancialAmendmentServiceModel model) {

        // model itself must not be null.
        return Optional.ofNullable(model.getLendingAmendRateRevisionData())
                .map(LendingAmendRateRevisionDataModel::getRateRefreshFrequency)
                .orElse(null);
    }

    public static void main(String[] args) {
        // Case 1: Data and frequency both exist.
        FinancialAmendmentServiceModel withFrequency =
                new FinancialAmendmentServiceModel(
                        new LendingAmendRateRevisionDataModel("MONTHLY"));

        // Case 2: Rate-revision data is missing.
        FinancialAmendmentServiceModel withoutData =
                new FinancialAmendmentServiceModel(null);

        // Case 3: Data exists, but its frequency is missing.
        FinancialAmendmentServiceModel withoutFrequency =
                new FinancialAmendmentServiceModel(
                        new LendingAmendRateRevisionDataModel(null));

        System.out.println(getRefreshFrequency(withFrequency));
        System.out.println(getRefreshFrequency(withoutData));
        System.out.println(getRefreshFrequency(withoutFrequency));
    }

    static class LendingAmendRateRevisionDataModel {
        private final String rateRefreshFrequency;

        LendingAmendRateRevisionDataModel(String frequency) {
            this.rateRefreshFrequency = frequency;
        }

        String getRateRefreshFrequency() {
            return rateRefreshFrequency;
        }
    }

    static class FinancialAmendmentServiceModel {
        private final LendingAmendRateRevisionDataModel rateRevisionData;

        FinancialAmendmentServiceModel(
                LendingAmendRateRevisionDataModel rateRevisionData) {
            this.rateRevisionData = rateRevisionData;
        }

        LendingAmendRateRevisionDataModel getLendingAmendRateRevisionData() {
            return rateRevisionData;
        }
    }
}
