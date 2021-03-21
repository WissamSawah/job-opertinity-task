<template>
    <div class="submit-form mt-3 mx-auto">
        <p class="headline">
            Book Resources
        </p>

        <div v-if="!submitted">
            <v-form
                ref="form"
                @submit.prevent="saveResources"
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
                    label="Resource to book"
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
                    type="submit"
                    :disabled="!isValid"
                >
                    Book
                </v-btn>
            </v-form>
        </div>
        <div v-else>
            <v-card class="mx-auto">
                <v-alert
                    dense
                    text
                    type="success"
                >
                    Resource booked successfully!
                </v-alert>
            </v-card>
        </div>
    </div>
</template>

<script>
    import BookingResourceService from "../services/BookingResourceService";

    export default {
        name: "BookResources",
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
            saveResources() {
                var data = {
                    clientId: this.resources.clientId,
                    bookedResource: this.resources.bookedResource
                };

                BookingResourceService.book(data)
                    .then((response) => {
                        this.resources.clientId = response.data.clientId;
                        console.log(response.data);
                        this.submitted = true;
                    })
                    .catch((e) => {
                        console.log(e);
                        this.error = true;
                        this.errorMsg = e.response.data.reason;
                    });
            },

            newResources() {
                this.submitted = false;
                this.resources = {};
            },

        },

    };
</script>

<style>
.submit-form {
  max-width: 300px;
}
</style>
