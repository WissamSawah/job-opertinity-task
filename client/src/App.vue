<template>
    <v-app>
        <component :is="layout">
            <router-view :layout.sync="layout" />
        </component>
    </v-app>
</template>

<script>

    export default {
        name: 'App',
        data: () => ({
            layout: `div`,
        }),
    };
</script>

<style>
@import './css/style.scss';

</style>
