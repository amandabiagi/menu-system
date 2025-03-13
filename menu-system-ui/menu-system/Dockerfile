# Etapa 1: build da aplicação Angular
FROM node:20 AS build

WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Etapa 2: Servir com nginx
FROM nginx:alpine
COPY --from=build /app/dist/menu-system /usr/share/nginx/html

# Expor a porta 80 para o nginx
EXPOSE 80

# Comando para rodar o servidor nginx
CMD ["nginx", "-g", "daemon off;"]
