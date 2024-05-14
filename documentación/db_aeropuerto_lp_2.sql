CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50) -- AdministradorAerolinea, AdministradorAbordaje
);

--CATALOGO DE AEROLINEA
CREATE TABLE aerolinea (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(100),
    modificado_por VARCHAR(100)
);

--ENTIDAD USUARIO*AEROLINEAS
CREATE TABLE usuario_aerolinea (
	id SERIAL PRIMARY KEY,
    usuario_id INT REFERENCES cliente(id),
    aerolinea_id INT REFERENCES aerolinea(id)
);

--CATALOGO DE AVIONES
CREATE TABLE avion (
    id SERIAL PRIMARY KEY,
    estado bool null,
    modelo VARCHAR(100),
    marca VARCHAR(100),
    anio INT,
    capacidad_pasajeros INT,
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(100),
    modificado_por VARCHAR(100)
);

--CATALOGO DE AEROPUERTOS
CREATE TABLE aeropuerto (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    ciudad VARCHAR(100),
    pais VARCHAR(100),
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(100),
    modificado_por VARCHAR(100)
);

--CLIENTE/PASAJERO
CREATE TABLE pasajero (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    pasaporte VARCHAR(20),
    nacionalidad VARCHAR(100),
    edad INT,
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100)
);

CREATE TABLE vuelo (
    id SERIAL PRIMARY KEY,
    aerolinea_id INT REFERENCES aerolinea(id),
    aeropuerto_salida_id INT REFERENCES aeropuerto(id),
    aeropuerto_llegada_id INT REFERENCES aeropuerto(id),
    avion_id INT REFERENCES Avion(id),
    fecha_hora_salida TIMESTAMP,
    fecha_hora_llegada TIMESTAMP,
    precio_clase_economica DECIMAL(10, 2),
    precio_clase_ejecutiva DECIMAL(10, 2)
);

create table clase_vuelo(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(100),
    modificado_por VARCHAR(100)
);

--ENTIDAD VUELO*PASAJERO
CREATE TABLE boleto (
	id SERIAL PRIMARY key,
    pasajero_id INT REFERENCES pasajero(id),
    numero_vuelo_id INT REFERENCES vuelo(id),
    clase_vuelo_id INT references clase_vuelo(id),
    asiento VARCHAR(10),
    cantidad_maletas INT
);

--CATALOGO DE TRIPULACION
CREATE TABLE tripulacion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    tipo_puesto TEXT,-- Piloto, Copiloto, Ingeniero de vuelo, Tripulante de cabina
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(100),
    modificado_por VARCHAR(100)
);


--ENTIDAD TRIPULACION*VUELO
CREATE TABLE tripulacion_vuelo (
	id SERIAL PRIMARY key,
    tripulacion_id INT REFERENCES tripulacion(id),
    numero_vuelo_id INT REFERENCES vuelo(id)
);

CREATE TABLE destino (
    id SERIAL PRIMARY KEY,
    aerolinea_id INT REFERENCES aerolinea(id),
    aeropuerto_id INT REFERENCES aeropuerto(id),
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(100),
    modificado_por VARCHAR(100)
);

--ENTIDAD AVION*AEROLINEA
CREATE TABLE avion_aerolinea (
	id SERIAL primary key,
    avion_id INT REFERENCES avion(id),
    aerolinea_id INT REFERENCES aerolinea(id)
);
