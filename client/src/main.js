import Vue from 'vue';
import App from './App.vue';
import router from './router';
import '../src/css/style.scss';


import vuetify from './plugins/vuetify';
import 'roboto-fontface/css/roboto/roboto-fontface.css';
import '@mdi/font/css/materialdesignicons.css';



Vue.config.productionTip = false;

Vue.use(vuetify);

new Vue({
  render: h => h(App),
  vuetify,
  router
}).$mount('#app');
