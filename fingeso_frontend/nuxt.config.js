import colors from 'vuetify/es5/util/colors'

export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    titleTemplate: '%s - Fingeso',
    title: 'Fingeso',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/vuetify
    '@nuxtjs/vuetify',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    '@nuxtjs/axios',
  ],

  axios : {
    //baseURL: 'http//localhost:8080',
    baseURL: 'http://localhost:8080',
    proxy: true,
  },

  proxy: {
    "/admin/getAll": 'http://localhost:8080',
    "/admin/login/": 'http://localhost:8080',
    "/admin/findByID/": 'http://localhost:8080',
    "/deuda/getAll": 'http://localhost:8080',
    "/deuda/deudasPorResidente/": 'http://localhost:8080',
    "/deuda/findByID/": 'http://localhost:8080',
    "/subadmin/login/": 'http://localhost:8080',
    "/residente/login/": 'http://localhost:8080',
    "/personal/login/": 'http://localhost:8080',
    "/edificio/getAll": 'http://localhost:8080',
    "/departamento/deptsPorEdificio/": 'http://localhost:8080',
    "/gastoComun/addGasto/" : 'http://localhost:8080',
  },

  // Vuetify module configuration: https://go.nuxtjs.dev/config-vuetify
  vuetify: {
    customVariables: ['~/assets/variables.scss'],
    theme: {
      dark: false,
      themes: {
        dark: {
          primary: colors.blue.darken2,
          accent: colors.grey.darken3,
          secondary: colors.amber.darken3,
          info: colors.teal.lighten1,
          warning: colors.amber.base,
          error: colors.deepOrange.accent4,
          success: colors.green.accent3
        }
      }
    }
  },

  

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  }
}
