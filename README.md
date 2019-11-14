<h3>Taller de modelo y validación</h3>
<h4>Arquitectura de MicroServicios</h4>

Se implementó una arquitectura de micro servicios, pensando en el desacoplamiento y responsabilidad única, buscando una solución acorde a la necesidad del Banco ABC. 

La arquitectura se soporta en diferentes patrones, los cuales son:
<ul>
<li>Pattern: Service registry
Se realiza el descubrimiento de los servicios mediante API swaggers con especificación open api 3.0. Permitiendo al cliente acceder a las diferentes operaciones expuestas, contratos, y esquemas.</li>
Pattern: Database per service
Se implementan base de datos por servicio, obligando a que cualquier necesidad de acceso a sus datos se realice por un único servicio. 
Pattern: Service instance per container
Se crean contenedores docker independientes para cada servicio, orquestados por kubernetes.
Pattern: API Gateway 
Se realiza la implementación de un API Gateway, con swagger hub. Permitiéndonos acceder desde un solo punto a los diferentes servicios expuestos por el Banco ABC.
Pattern: API Composition
Se implementa un servicio que se comporta como api composition, donde el api consulta los diferentes servicios y retorna la unión de las repuestas. Permitiendo hacer una composición por orquestación.  
Pattern: Proxy
Se implementa el patrón proxy, en el servicio de transformación de XML y JSON. Permitiendo delegar la responsabilidad del manejo de excepciones presentadas.
Pattern: Intermediate Routing
Se realiza el enrutamiento de acuerdo a las referencias enviadas por los clientes, permitiéndonos saber cuál es el convenio y así el servicio a invocar.
Pattern: Dependency injection
La creación de objetos entre capas lógicas se realiza mediante inyección de dependencias.
Pattern: Repository
La mediación entre el dominio de negocio y la persistencia se la delegamos a un repositorio. 
</ul>
