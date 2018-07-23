var defaultCursor = null;

var tileLayer = new BMap.TileLayer();
tileLayer.getTilesUrl = function(tileCoord, zoom) {
	var x = tileCoord.x;
	var y = tileCoord.y;
	var url = outputPath + zoom + '/' + x + '/' + y + format;
	return url;
}
var tileMapType = new BMap.MapType('tileMapType', tileLayer, {minZoom: minLevel, maxZoom: maxLevel});
var map = new BMap.Map('map', {mapType: tileMapType});

// 启用滚轮放大缩小
map.enableScrollWheelZoom();
map.enableContinuousZoom();
