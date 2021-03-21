import Vue from "vue";
import Router from "vue-router";
import ListResources from "@/components/ListResources";
import AddResources from "@/components/AddResources";
import BookResources from "@/components/BookResources";
import ReleaseResources from "@/components/ReleaseResources";

Vue.use(Router);

const routes = [
    {
        path: "/",
        alias: "/resources",
        name: "resources",
        component: ListResources
    },
    {
        path: "/add",
        name: "add",
        component: AddResources
    },
    {
        path: "/book",
        name: "book",
        component: BookResources
    },
    {
        path: "/release",
        name: "release",
        component: ReleaseResources
    }
];

const router = new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;
