<template>
    <div class="submit-form mt-3 mx-auto">
        <p class="headline">
            Add Resources
        </p>

        <div v-if="!submitted">
            <v-form
                ref="form"
                @submit.prevent="saveResources"
                v-model="isValid"
            >
                <v-text-field
                    v-model="hostName"
                    label="Host Name"
                    :rules="[v => !!v || 'Hostname is required']"
                    required
                />
                <v-text-field
                    v-model="bookingLimit"
                    label="booking Limit"
                    :rules="[v => !!v || 'bookingLimit is required']"
                    required
                />
                <br>
                <v-alert
                    v-if="error"
                    dense
                    elevation="15"
                    type="error"
                >
                    Host name should be unique!
                </v-alert>

                <v-btn
                    color="primary"
                    class="mt-3"
                    type="submit"
                    :disabled="!isValid"
                >
                    Add
                </v-btn>
            </v-form>
        </div>

        <div v-else>
            <v-card>
                <v-alert
                    dense
                    text
                    type="success"
                >
                    New resource added successfully!
                </v-alert>
            </v-card>
        </div>
    </div>
</template>

<script>
    import BookingResourceService from "../services/BookingResourceService";
    export default {
        name: "AddResources",
        data() {
            return {
                error: false,
                hostName: null,
                bookingLimit: null,
                submitted: false,
                isValid: false
            };
        },
        methods: {
            saveResources() {
                var data = {
                    hostName: this.hostName,
                    bookingLimit: this.bookingLimit
                };

                BookingResourceService.create(data)
                    .then((response) => {
                        this.hostName = response.data.hostName;
                        this.submitted = true;
                    })
                    .catch((e) => {
                        console.log(e);
                        this.error = true;
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
