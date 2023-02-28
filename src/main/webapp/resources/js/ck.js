
CKEDITOR.editorConfig = function (config)
{
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    // config.uiColor = '#AADC6E';
    config.toolbar = 'Custom';
    config.extraPlugins = 'quicktable';
    config.resize_enabled = true;
    config.extraPlugins = 'tableresize';

    config.contentsLangDirection = 'rtl';
    config.dialog_buttonsOrder = 'rtl';

    config.contentsLanguage = 'ar';
    config.language = 'ar';
    config.scayt_sLang = 'ar_SA';




    config.toolbar_Custom = [
        {
            name: 'document',
            items: ['Source', 'Preview', 'Print', '-']
        },
        {
            name: 'clipboard',
            items: ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo']
        },
        {
            name: 'editing',
            items: ['Find', 'Replace', '-', 'SelectAll', '-']
        },
        {
            name: 'forms',
            items: ['Checkbox', 'Radio', 'TextField', 'Textarea']
        },
        {
            name: 'paragraph',
            items: ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter',
                'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl']
        }, {
            name: 'links',
            items: ['Link', 'Unlink', 'Anchor']
        }, {
            name: 'insert',
            items: ['Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak']
        },
        {
            name: 'basicstyles',
            items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat']
        }, {
            name: 'styles',
            items: ['Styles', 'Format', 'Font', 'FontSize']
        }, {
            name: 'colors',
            items: ['TextColor', 'BGColor']
        }, {
            name: 'tools',
            items: ['Maximize']
        }];

};
