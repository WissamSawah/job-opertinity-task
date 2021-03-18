import Vue from 'vue';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#00eacc',
        secondary: '#ccc',
        accent: '#82B1FF',
        error: '#FF5252',
        btn: '#00eacc',
        success: '#4CAF50',
        warning: '#FFC107'
      },
    },
  },
});
