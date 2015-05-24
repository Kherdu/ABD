xquery version "3.0";

declare variable $anyo as xs:integer external;

let $ed := doc("Eurovision.xml")//edicion[anyo/text()=$anyo]
for $pais in $ed/pais
let $idAut := $pais//participante/@id
let $artista := doc("Eurovision.xml")//artista[idc/text()=$idAut]
let $puntuacion := sum($pais//puntuacion)
order by $puntuacion descending
return <clasificacion pais=" {data($pais/@nombre)} " cancion=" {$pais/cancion/text()} "
artista=" {$artista/nombre/text()} " puntos=" {$puntuacion} "/>


