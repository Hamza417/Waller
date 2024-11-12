package app.simple.peri.compose.dialogs.wallpaper

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import app.simple.peri.R
import app.simple.peri.compose.constants.DIALOG_OPTION_FONT_SIZE
import app.simple.peri.compose.dialogs.common.ShowWarningDialog
import app.simple.peri.models.Wallpaper

@Composable
fun ScreenSelectionDialog(setShowDialog: (Boolean) -> Unit, context: Context, drawable: Drawable?, wallpaper: Wallpaper) {
    val shouldExport = remember { mutableStateOf(false) }
    val showDoneDialog = remember { mutableStateOf(false) }

    if (shouldExport.value) {
        ExportWallpaper(context, drawable!!, wallpaper) {
            shouldExport.value = false
            showDoneDialog.value = true
        }
    }

    if (showDoneDialog.value) {
        ShowWarningDialog(
                title = context.getString(R.string.exported),
                warning = wallpaper.name!!.substringBeforeLast(".") + "_edited.png",
                onDismiss = {
                    setShowDialog(false)
                    showDoneDialog.value = false
                }
        )
    }

    AlertDialog(
            onDismissRequest = { setShowDialog(false) },
            title = {
                Text(
                        text = stringResource(id = R.string.set_as_wallpaper),
                )
            },
            text = {
                Column {
                    Button(
                            onClick = {
                                setWallpaper(context, WallpaperManager.FLAG_LOCK, drawable!!)
                                setShowDialog(false)
                            },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.onSurface,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                    ) {
                        Text(
                                text = context.getString(R.string.lock_screen),
                                fontSize = DIALOG_OPTION_FONT_SIZE,
                                color = MaterialTheme.colorScheme.onSurface,
                                fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                            onClick = {
                                setWallpaper(context, WallpaperManager.FLAG_SYSTEM, drawable!!)
                                setShowDialog(false)
                            },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                    ) {
                        Text(
                                text = context.getString(R.string.home_screen),
                                fontSize = DIALOG_OPTION_FONT_SIZE,
                                color = MaterialTheme.colorScheme.onSurface,
                                fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                            onClick = {
                                setWallpaper(context, WallpaperManager.FLAG_SYSTEM or WallpaperManager.FLAG_LOCK, drawable!!)
                                setShowDialog(false)
                            },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.onSurface,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                    ) {
                        Text(
                                text = context.getString(R.string.both),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = DIALOG_OPTION_FONT_SIZE,
                                fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                            onClick = {
                                shouldExport.value = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.onSurface,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                    ) {
                        Text(
                                text = context.getString(R.string.export),
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = DIALOG_OPTION_FONT_SIZE,
                                fontWeight = FontWeight.Bold
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                        onClick = {
                            setShowDialog(false)
                        })
                {
                    Text(stringResource(id = R.string.cancel))
                }
            },
    )
}

fun setWallpaper(context: Context, flags: Int, drawable: Drawable) {
    val wallpaperManager = WallpaperManager.getInstance(context)
    wallpaperManager.setWallpaperOffsetSteps(0F, 0F)
    wallpaperManager.setBitmap(drawable.toBitmap(), null, true, flags)
}

@Composable
fun ExportWallpaper(context: Context, drawable: Drawable, wallpaper: Wallpaper, onExport: () -> Unit = {}) {
    val wallpaperExportLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.CreateDocument("image/x-png")) { uri ->
        uri?.let {
            context.contentResolver.openOutputStream(it)?.use { outputStream ->
                drawable.toBitmap().compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            }

            onExport()
        }
    }

    LaunchedEffect(Unit) {
        val extension = wallpaper.name?.substringAfterLast(".")
        val fileName = wallpaper.name?.replace(extension!!, "_edited.png") ?: "edited.png"
        wallpaperExportLauncher.launch(fileName)
    }
}
