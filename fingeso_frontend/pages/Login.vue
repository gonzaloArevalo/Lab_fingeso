<script>
</script>
<template>
  <main>
    <body style="background-color: rgb(18, 16, 16); height: 100vh; margin: 0; display: flex; align-items: center; justify-content: center;">
      <div class="general">
        <div class="content">
          <div class="header" style="color: white; font-size: 30px; margin-bottom: 20px;">Inicio de sesión</div>
          <div class="headerDescription" v-if="!register"></div>
          <div class="inputContainers" v-if="!register" style="margin-bottom: 20px;">
            <input type="email" style="color: white; background-color: rgb(0, 67, 126);" v-model="username" placeholder="Correo" />
            <input type="password" style="color: white; background-color: rgb(0, 67, 126);" v-model="password" placeholder="Contraseña" />
            <button style="color: white;" class="sessionButton" @click="login"> Iniciar Sesión </button>
          </div>
        </div>
      </div>
    </body>
  </main>
</template>
<script>
</script>

export default {
    name: 'IndexPage',
}
</script>
  