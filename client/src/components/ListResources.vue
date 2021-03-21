<template>
    <div class="cen col-md-5">
        <h1 style="text-align:center;">
            Resources
        </h1>

        <div class="input-group mb-8">
            <v-expansion-panels focusable>
                <v-expansion-panel
                    class="list-group-item"
                    :class="{ active: index == currentIndex }"
                    v-for="(resource, index) in resources"
                    :key="index"
                    @click="setActiveResources(resource, index)"
                >
                    <v-expansion-panel-header>
                        <b>
                            Name:
                        </b>
                        <p
                            class="name"
                            style="text-align:center;"
                        >
                            {{ resource.hostName }}
                        </p>
                        <b>
                            Status:
                        </b>
                        <span
                            class="full-booked"
                            v-if="resource.bookings.length == resource.bookingLimit"
                        >
                            Fully booked
                        </span>

                        <span
                            class="available"
                            v-else
                        >
                            Available
                        </span>
                    </v-expansion-panel-header>
                    <v-expansion-panel-content
                        class="content"
                        v-if="currentResource"
                    >
                        <label><strong>ID:</strong></label>
                        {{ currentResource.id }}
                        <br>
                        <label><strong>Host Name:</strong></label>

                        {{ currentResource.hostName }}
                        <br>
                        <label><strong>Booking Limit:</strong></label>

                        {{ currentResource.bookingLimit }}
                        <br>

                        <span
                            v-if="currentResource.bookings.length > 0"
                        >
                            <strong>Booked By:</strong>
                            {{ currentResource.bookings.join(', ') }}
                        </span>
                    </v-expansion-panel-content>
                </v-expansion-panel>
            </v-expansion-panels>
        </div>
    </div>
</template>

<script>
    import BookingResourceService from "../services/BookingResourceService";

    export default {
        name: "ReourcesList",
        data() {
            return {
                resources: [],
                currentResource: null,
                currentIndex: -1,
                hostName: "",
                booking: "",
                bookings: []
            };
        },

        methods: {
            retrieveResources() {
                BookingResourceService.getAll()
                    .then(response => {
                        this.resources = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },

            setActiveResources(resource, index) {
                this.currentResource = resource;
                this.currentIndex = index;
            },
        },
        mounted() {
            this.retrieveResources();
        }
    };
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
