@echo off
call gradlew build
rem put deploy code here (example provided grabs the latest from the build\libs folder and copies it to my minecraft 1.8.0 mods\1.8 folder.
rem FOR /F "delims=" %%I IN ('DIR D:\Games\Forge_Eclipse_workspace\AnimalsDropBones\build\libs /B /O:-D') DO echo %%I&call XCOPY D:\Games\Forge_Eclipse_workspace\AnimalsDropBones\build\libs\%%I D:\Games\.Minecraft1.8.0\mods\1.8& GOTO :EXIT
:EXIT
pause