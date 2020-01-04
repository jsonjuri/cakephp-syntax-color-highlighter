package com.jsonjuri.settings;

import com.intellij.icons.AllIcons;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.util.ObjectUtils;
import com.intellij.util.PlatformUtils;
import com.jsonjuri.annotators.CakePHPAnnotator;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

import javax.swing.Icon;

import gnu.trove.THashMap;

public class CakePHPColorSettings extends BaseColorSettings {
  @NonNls
  static final AttributesDescriptor[] PHP_ATTRIBUTES;
  @NonNls
  static final Map<String, TextAttributesKey> PHP_DESCRIPTORS = new THashMap<>();

  private static final TextAttributesKey PHP_KEYWORD = ObjectUtils.notNull(TextAttributesKey.find("PHP_KEYWORD"), DefaultLanguageHighlighterColors.KEYWORD);
  private static final TextAttributesKey VARIABLE = ObjectUtils.notNull(TextAttributesKey.find("PHP_VAR"), DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

  private static final TextAttributesKey CAKE_PHP_MODEL_PROPERTIES = CakePHPAnnotator.CAKE_PHP_MODEL_PROPERTIES;
  private static final TextAttributesKey CAKE_PHP_MODEL_METHODS = CakePHPAnnotator.CAKE_PHP_MODEL_METHODS;
  private static final TextAttributesKey CAKE_PHP_MODEL_CALLBACKS = CakePHPAnnotator.CAKE_PHP_MODEL_CALLBACKS;
  private static final TextAttributesKey CAKE_PHP_CONTROLLER_METHODS = CakePHPAnnotator.CAKE_PHP_CONTROLLER_METHODS;
  private static final TextAttributesKey CAKE_PHP_CONTROLLER_CALLBACKS = CakePHPAnnotator.CAKE_PHP_CONTROLLER_CALLBACKS;
  private static final TextAttributesKey CAKE_PHP_COMPONENTS = CakePHPAnnotator.CAKE_PHP_COMPONENTS;
  private static final TextAttributesKey CAKE_PHP_SESSION_COMPONENTS = CakePHPAnnotator.CAKE_PHP_SESSION_COMPONENTS;
  private static final TextAttributesKey CAKE_PHP_MISC = CakePHPAnnotator.CAKE_PHP_MISC;

  static {
    PHP_ATTRIBUTES = new AttributesDescriptor[]{
        new AttributesDescriptor("Keywords: actsAs, belongsTo, hasMany, hasOne", CakePHPColorSettings.CAKE_PHP_MODEL_PROPERTIES),
        new AttributesDescriptor("Keywords: bindModel, loadModel, create, clear, set", CakePHPColorSettings.CAKE_PHP_MODEL_METHODS),
        new AttributesDescriptor("Keywords: beforeSave, afterSave, beforeFind, afterFind", CakePHPColorSettings.CAKE_PHP_MODEL_CALLBACKS),
        new AttributesDescriptor("Keywords: cleanUpFields, redirect, render, element", CakePHPColorSettings.CAKE_PHP_CONTROLLER_METHODS),
        new AttributesDescriptor("Keywords: initialize, startup, beforeFilter, beforeRender, afterFilter", CakePHPColorSettings.CAKE_PHP_CONTROLLER_CALLBACKS),
        new AttributesDescriptor("Keywords: Paginator, Security, Mail, RequestHandler", CakePHPColorSettings.CAKE_PHP_COMPONENTS),
        new AttributesDescriptor("Keywords: Acl, Auth, Cookie, Session", CakePHPColorSettings.CAKE_PHP_SESSION_COMPONENTS),
        new AttributesDescriptor("Keywords: controller, request, response", CakePHPColorSettings.CAKE_PHP_MISC),
    };

    CakePHPColorSettings.PHP_DESCRIPTORS.putAll(CakePHPColorSettings.createAdditionalHlAttrs());
  }

  private static Map<String, TextAttributesKey> createAdditionalHlAttrs() {
    final Map<String, TextAttributesKey> descriptors = new THashMap<>();
    descriptors.put("keyword", CakePHPColorSettings.PHP_KEYWORD);
    descriptors.put("function", CakePHPColorSettings.PHP_KEYWORD);
    descriptors.put("var", CakePHPColorSettings.VARIABLE);
    descriptors.put("model_property", CakePHPColorSettings.CAKE_PHP_MODEL_PROPERTIES);
    descriptors.put("model_method", CakePHPColorSettings.CAKE_PHP_MODEL_METHODS);
    descriptors.put("model_callback", CakePHPColorSettings.CAKE_PHP_MODEL_CALLBACKS);
    descriptors.put("controller_method", CakePHPColorSettings.CAKE_PHP_CONTROLLER_METHODS);
    descriptors.put("controller_callback", CakePHPColorSettings.CAKE_PHP_CONTROLLER_CALLBACKS);
    descriptors.put("component", CakePHPColorSettings.CAKE_PHP_COMPONENTS);
    descriptors.put("session_component", CakePHPColorSettings.CAKE_PHP_SESSION_COMPONENTS);
    descriptors.put("cake_misc", CakePHPColorSettings.CAKE_PHP_MISC);

    return descriptors;
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return AllIcons.FileTypes.JavaScript;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    final Language lang = ObjectUtils.notNull(Language.findLanguageByID("PHP"), Language.ANY);
    return getSyntaxHighlighterWithFallback(lang);
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "<keyword>public</keyword> <model_property>$useTable</model_property> = 'hello_world';\n" +
            "<keyword>public</keyword> <model_property>$belongsTo</model_property> = [];\n" +
            "<keyword>public</keyword> <model_property>$hasMany</model_property> = [];\n" +
            "\n" +
            "<keyword>public</keyword> <function>function</function> <controller_callback>beforeFilter</controller_callback>() {\n" +
            "    <keyword>parent</keyword>::<controller_callback>beforeFilter</controller_callback>();\n" +
            "    <var>$this</var>-><component>Security</component>->blackHoleCallback = 'blackhole';\n" +
            "    <var>$email</var> = <var>$this</var>-><cake_misc>request</cake_misc>-><keyword>data</keyword>('User.Email');\n" +
            "    <var>$this</var>-><cake_misc>controller</cake_misc>-><keyword>params</keyword>['pass'][0];\n" +
            "    <var>$this</var>-><session_component>Auth</session_component>-><keyword>deny</keyword>();\n" +
            "}\n" +
            "\n" +
            "<keyword>public</keyword> <function>function</function> <controller_callback>beforeRender</controller_callback>() {\n" +
            "    <keyword>parent</keyword>::<controller_callback>beforeFilter</controller_callback>();\n" +
            "    <var>$this</var>-><model_method>set</model_method>('hello', 'world');\n" +
            "    <keyword>return</keyword> <var>$this</var>-><controller_method>render</controller_method>('template');\n" +
            "}\n" +
            "\n" +
            "<keyword>public</keyword> <function>function</function> <model_callback>afterFind</model_callback>() {\n" +
            "    <keyword>parent</keyword>::<model_callback>afterFind</model_callback>();\n" +
            "    <var>$results</var> = <var>$this</var>-><model_method>find</model_method>('all');\n" +
            "    <keyword>return</keyword> <var>$results</var>;\n" +
            "}\n";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return PHP_DESCRIPTORS;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return PHP_ATTRIBUTES;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "CakePHP Colors";
  }

  @Override
  public DisplayPriority getPriority() {
    return PlatformUtils.isWebStorm() ? DisplayPriority.KEY_LANGUAGE_SETTINGS : DisplayPriority.LANGUAGE_SETTINGS;
  }
}
