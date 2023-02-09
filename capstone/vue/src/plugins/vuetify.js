import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    iconfont: 'md',
    breakpoint: {
        xs: 340,
        sm: 540,
        md: 800,
        lg: 1280,
        // mobileBreakpoint: 'sm' //This is the equivalent value of 960
    },
    scrollBarWidth: 24,
    theme: {
        themes: {
            light: {
                primary: '#1E88E5',
                secondary: '#f2be90',
                accent: '#CFD8DC',
                error: '#b71c1c',
            },
        },
    },

});
