xquery version "3.0";

declare variable $anyo as xs:integer := 2015;

let $ed := doc("eurovision.xml")//edicion[anyo/text()=$anyo]
for $pais in $ed/pais
let $artista := doc("eurovision.xml")//artista[@id=$pais/participante/@id]
let $puntuacion := sum($pais//puntuacion)
order by $puntuacion descending
return <clasificacion pais=" {data($pais/@nombre)} " cancion=" {$pais/cancion/text()} "
artista=" {$artista/nombre/text()} " puntos=" {$puntuacion} "/>


