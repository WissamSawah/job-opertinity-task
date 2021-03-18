<template>
    <div class="home">
        <hello-world />
    </div>
</template>

<script>
// @ is an alias to /src
    import HelloWorld from '@/components/HelloWorld.vue';
    import DashboardLayout from '../layouts/DashboardLayout';
    


    export default {
        name: 'Home',
        components: {
            HelloWorld
        },
        created(){
            this.$emit(`update:layout`, DashboardLayout);
        }
    };
</script>
