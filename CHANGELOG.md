## [1.1.0]

- Added config:
    - Mobs occasionally spawn with flower garlands from their corresponding biomes, all indicated with [new biome tags](https://github.com/davidjjung/wilderflowers/tree/1.20.1/src/main/resources/data/wilderflowers/tags/worldgen/biome).
        - Both normal and increased flower garland spawn chance included by % chance in config. Flower Forests are the only biome included in `wilderflowers:frequent_garlands` by default
    - Added mob behavior config options:
        - Mobs in the tag `wilderflowers:garland_wearers` may behave as either passive or neutral (both disabled by default)
- Added Russian translation.
- Added Chinese Translation.
- Fixed missing tags.
- Port to 26.1-snapshot-4.
- Fixed crash on 1.21.1 Fabric dedicated server.

## [1.0.4]

### Added
- Added support for Supplementaries Flower Boxes.

### Fixed
- Flower pots are now properly tagged.

## [1.0.3]

### Changed
- Improved textures and models (@ProbablyEkho)

### Fixed
- Crash on NeoForge 1.21.10

## [1.0.2]

### Fixed
- Support for Java 17

## [1.0.1]

### Added
- 1.21.8 support

### Changed
- Removed embedded Lithostitched dependency.

### Fixed
- Wildflowers now use the grass colour map instead of either a hardcoded colour or the foliage map.
- Playful wilderflower garlands not displaying correctly when worn.
- Playful wildflower textures.