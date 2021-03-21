<template>
    <div class="submit-form mt-3 mx-auto">
        <p class="headline">
            Release getBookings
        </p>

        <div v-if="!submitted">
            <v-form
                ref="form"
                @submit.prevent="releaseResource"
                v-model="isValid"
            >
                <v-text-field
                    v-model="resources.clientId"
                    :rules="[(v) => !!v || 'clientId is required']"
                    label="clientId"
                    required
                />
                <v-text-field
                    v-model="resources.bookedResource"
                    :rules="[(v) => !!v || 'bookedResource is required']"
                    label="Booked Resource"
                    required
                />
                <br>
                <v-alert
                    v-if="error"
                    dense
                    elevation="15"
                    type="error"
                >
                    {{ errorMsg }}
                </v-alert>
                <v-btn
                    color="primary"
                    class="mt-3"
                    :disabled="!isValid"
                    type="submit"
                >

                    Release
                </v-btn>
            </v-form>
        </div>
        <div v-else>
            <v-card class="mx-auto">
                <v-card-title>
                    Submitted successfully!
                </v-card-title>
            </v-card>
        </div>
    </div>
</template>

<script>
    import BookingResourceService from "../services/BookingResourceService";

    export default {
        name: "ReleaseResources",
        data() {
            return {
                error: false,
                resources: {
                    clientId: null,
                    bookedResource: null
                },
                submitted: false,
                isValid: false,
                errorMsg: ''
            };
        },
        methods: {
            releaseResource() {
                var data = {
                    clientId: this.resources.clientId,
                    bookedResource: this.resources.bookedResource
                };

                BookingResourceService.delete(data)
                    .then((response) => {
                        this.resources.clientId = response.data.clientId,

                        console.log(response.data);
                        this.submitted = true;
                    })
                    .catch((e) => {
                        console.log(e);
                        this.errorMsg = e.response.data.reason;
                        this.error = true;
                    });
            },

        },

    };
</script>

<style>
.submit-form {
  max-width: 300px;
}
</style>
