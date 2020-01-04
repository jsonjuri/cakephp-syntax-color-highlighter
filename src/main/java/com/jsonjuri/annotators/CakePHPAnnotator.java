package com.jsonjuri.annotators;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.util.ObjectUtils;

import org.jetbrains.annotations.NotNull;

public class CakePHPAnnotator extends BaseAnnotator {

  private static final TextAttributesKey PHP_KEYWORD = ObjectUtils.notNull(TextAttributesKey.find("PHP_KEYWORD"), DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey CAKE_PHP_MODEL_PROPERTIES = TextAttributesKey.createTextAttributesKey("CAKE_PHP_MODEL_PROPERTIES", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_MODEL_METHODS = TextAttributesKey.createTextAttributesKey("CAKE_PHP_MODEL_METHODS", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_MODEL_CALLBACKS = TextAttributesKey.createTextAttributesKey("CAKE_PHP_MODEL_CALLBACKS", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_CONTROLLER_METHODS = TextAttributesKey.createTextAttributesKey("CAKE_PHP_CONTROLLER_METHODS", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_CONTROLLER_CALLBACKS = TextAttributesKey.createTextAttributesKey("CAKE_PHP_CONTROLLER_CALLBACKS", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_COMPONENTS = TextAttributesKey.createTextAttributesKey("CAKE_PHP_COMPONENTS", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_SESSION_COMPONENTS = TextAttributesKey.createTextAttributesKey("CAKE_PHP_SESSION_COMPONENTS", PHP_KEYWORD);
  public static final TextAttributesKey CAKE_PHP_MISC = TextAttributesKey.createTextAttributesKey("CAKE_PHP_MISC", PHP_KEYWORD);

  @Override
  protected TextAttributesKey getKeywordKind(@NotNull final PsiElement element) {
    TextAttributesKey kind = null;
    switch (element.getText()) {
      case "actsAs":
      case "belongsTo":
      case "hasAndBelongsToMany":
      case "hasMany":
      case "hasOne":
      case "validationErrors":
      case "recursive":
      case "cacheQueries":
      case "primaryKey":
      case "displayField":
      case "useTable":
      case "useDbConfig":
      case "_tableInfo":
      case "$actsAs":
      case "$belongsTo":
      case "$hasAndBelongsToMany":
      case "$hasMany":
      case "$hasOne":
      case "$validate":
      case "$validationErrors":
      case "$recursive":
      case "$cacheQueries":
      case "$findMethods":
      case "$primaryKey":
      case "$displayField":
      case "$useTable":
      case "$useDbConfig":
      case "$_tableInfo":
        kind = CAKE_PHP_MODEL_PROPERTIES;
      break;

      case "bindModel":
      case "unbindModel":
      case "loadModel":
      case "create":
      case "clear":
      case "set":
      case "delete":
      case "deleteAll":
      case "updateAll":
      case "escapeField":
      case "execute":
      case "exists":
      case "find":
      case "findAll":
      case "findAllThreaded":
      case "findCount":
      case "findNeighbours":
      case "generateList":
      case "getAffectedRows":
      case "getColumnType":
      case "getColumnTypes":
      case "getDisplayField":
      case "getId":
      case "getNumRows":
      case "hasAny":
      case "hasField":
      case "invalidate":
      case "invalidFields":
      case "isForeignKey":
      case "loadInfo":
      case "query":
      case "read":
      case "write":
      case "remove":
      case "save":
      case "saveField":
      case "saveAssociated":
      case "setDataSource":
      case "setSource":
      case "validate":
      case "validateData":
      case "validateFields":
      case "validates":
        kind = CAKE_PHP_MODEL_METHODS;
      break;

      case "beforeSave":
      case "afterSave":
      case "beforeDelete":
      case "afterDelete":
      case "beforeFind":
      case "afterFind":
      case "beforeValidate":
      case "afterValidate":
      case "onError":
        kind = CAKE_PHP_MODEL_CALLBACKS;
      break;

      case "cleanUpFields":
      case "constructClasses":
      case "flash":
      case "FlashOut":
      case "generateFieldNames":
      case "PostConditions":
      case "redirect":
      case "referer":
      case "render":
      case "element":
      case "autoRender":
      case "viewClass":
      case "viewPath":
        kind = CAKE_PHP_CONTROLLER_METHODS;
      break;

      case "initialize":
      case "startup":
      case "beforeFilter":
      case "beforeRender":
      case "afterFilter":
      case "afterRender":
        kind = CAKE_PHP_CONTROLLER_CALLBACKS;
      break;

      case "Flash":
      case "Paginator":
      case "Email":
      case "RequestHandler":
      case "Security":
      case "Mail": // Start from here by adding your own components...
      case "Bucket":
      case "Pagination":
      case "Json":
      case "Account":
      case "Activity":
      case "Application":
      case "Emojione":
      case "Bot":
      case "Firebase":
      case "Verification":
      case "Password":
      case "Node":
      case "Integer":
      case "Widget":
        kind = CAKE_PHP_COMPONENTS;
      break;

      case "Acl":
      case "Auth":
      case "Cookie":
      case "Session":
      case "Token": // Start from here by adding your own components...
      case "Logged":
        kind = CAKE_PHP_SESSION_COMPONENTS;
      break;

      case "controller":
      case "request":
      case "response":
      case "_controller":
      case "_request":
      case "_response":
        kind = CAKE_PHP_MISC;
      break;
    }
    return kind;
  }
}
