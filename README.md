# Changelog
Changelog popup for android apps

## Usage
### Example 1
Basic changelog
``` java
Changelog changelog = new Changelog(this, R.xml.changelog);
changelog.show();
```
### Example 2
Customized changelog
``` java
Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
builder.setTitle("My app Changelog")
  .setReleaseColor(0x0000FF)
  .setReleaseDateColor(0x707070)
  .setStyle(new Changelog.StyleList(false).setBugBackgroundColor(0xFF0000).setBugColor(0xFFFFFF))
  .create()
  .show();
```

### Example 3
This code show a popup with what's new if the app was updated.
``` java
new Changelog(this, R.xml.changelog).showWhatsNew();
```


Put the changelog.xml file in res\xml. If your changelog is multilingual, add them in res\xml-{locale}.

``` xml
<?xml version="1.0" encoding="utf-8"?>
<changelog>
    <release version="1.2.0" versioncode="3" releasedate="2015-03-01" summary="my app summary.">
        <change type="new">[b]New![/b] Awesome new feature.</change>
        <change>This was [s]removed[/s].</change>
        <change type="bug">Bug [u][i]fixed[/i][/u].</change>
        <change type="improvement">Load faster.</change>
        <change>Translations added: italian, spanish.</change>
        <change><![CDATA[This feature is <font color='red'><b>deprecated</b></font>.]]></change>
    </release>
    <release version="1.1.0" versioncode="1">
        <change type="bug">Some typos fixed.</change>
        <change>Compatible with lollipop.</change>
    </release>
    <release version="1.0.0" versioncode="1" releasedate="January 1st 2014">
        <change>Initial version</change>
	</release>
</changelog>
```
