<template>
    <v-app>
        <v-app-bar
            app
            dark
        >
            <div class="d-flex align-center mr-2">
                ResourceBooking
            </div>

            <v-btn
                to="/resources"
                text
            >
                Resources
            </v-btn>

            <v-btn
                to="/add"
                text
            >
                Add Resource
            </v-btn>
            <v-btn
                to="/book"
                text
            >
                Book Resource
            </v-btn>
            <v-btn
                to="/release"
                text
            >
                Release Booking
            </v-btn>
        </v-app-bar>

        <v-main>
            <router-view />
        </v-main>
        <ftr />
    </v-app>
</template>

<script>
    import Footer from '../src/components/Footer';

    export default {

        name: "App",
        components: {

            ftr: Footer

        }
    };
</script>
