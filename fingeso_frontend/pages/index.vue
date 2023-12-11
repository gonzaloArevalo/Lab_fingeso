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
    <div>

        <v-btn @click="loginAdmin"> LOGIN ADMIN</v-btn>
        <v-btn @click="loginSubadmin"> LOGIN SUBADMIN</v-btn>
        <v-btn @click="loginResident"> LOGIN RESIDENTE</v-btn>
        <v-btn @click="loginPersonal"> LOGIN PERSONAL</v-btn>

    </div>
</template>