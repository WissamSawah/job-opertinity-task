<template>
    <div>
        <v-toolbar
            max-height="48px"
            color="#2f2f2f"
            dark
            dense
        >
            <v-app-bar-nav-icon />
            <v-toolbar-title>
                <v-img
                    :src="require('../assets/img/logo.png')"
                    class="my-3"
                    contain
                    width="35"
                />
            </v-toolbar-title>
            <v-spacer />
            <v-toolbar-items
                color="#2f2f2f"
                class="hidden-sm-and-dow"
            >
                <v-btn
                    flat
                    to="/"
                >
                    home
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <v-main>
            <slot />
        </v-main>
    </div>
</template>

<script>
// @ is an alias to /src
    import DashboardLayout from '../layouts/DashboardLayout';


    export default {
        created(){
            this.$emit(`update:layout`, DashboardLayout);
        }

    };
</script>
