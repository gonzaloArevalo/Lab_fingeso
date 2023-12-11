<script>

export default {
    methods: {
        async loginAdmin() {
            this.$router.push({ name: 'login', params: { userType: 1 } });
        },
        async loginResident() {
            this.$router.push({ name: 'login', params: { userType: 2 } });
        },
        async loginSubadmin() {
            this.$router.push({ name: 'login', params: { userType: 3 } });
        },
        async loginPersonal() {
            this.$router.push({ name: 'login', params: { userType: 4 } });
        },
    }


}
</script>


<template>
    <v-row>
        <v-col cols="12" class="text-center">
            <h1 style="color: rgb(46, 46, 114);">
                Seleccione una opción para iniciar sesión
            </h1>
        </v-col>
        <v-col>
            <v-btn @click="loginAdmin"> LOGIN ADMIN</v-btn>
        </v-col>
        <v-col>
            <v-btn @click="loginSubadmin"> LOGIN SUBADMIN</v-btn>
        </v-col>
        <v-col>
            <v-btn @click="loginResident"> LOGIN RESIDENTE</v-btn>
        </v-col>
        <v-col>
            <v-btn @click="loginPersonal"> LOGIN PERSONAL</v-btn>
        </v-col>
    </v-row>
</template>